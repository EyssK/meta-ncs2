# Openvino bb file
SUMMARY = "Compilation of Openvino"
DESCRIPTION = "Compile and install Openvino in imx"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "imx8mqevk"
DEPENDS = "opencv libusb1"
RDEPENDS_${PN} = "opencv"

INSANE_SKIP_${PN} += "already-stripped"

SOLIBS = ".so"
FILES_SOLIBSDEV = ""

inherit pkgconfig cmake
SRCREV = "ac65ea30fd90ec04bcf9a3c326f846d8f86f516d"
SRC_URI += " \
    git://github.com/openvinotoolkit/openvino;protocol=https \
    file://0001-Correction-remove-std-move.manualpatch   \
"
EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Release -DENABLE_SSE42=OFF -DTHREADING=SEQ -DENABLE_GNA=OFF"
S = "${WORKDIR}/git" 
# Cmake will look for host binaries, required for wget
OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "BOTH"

# Need submodules and patching a submodule
do_configure_prepend() {
  cd ${S}
  git submodule update --init --recursive
  cd inference-engine/thirdparty/ade/
  git am ${WORKDIR}/0001-Correction-remove-std-move.manualpatch
}

do_install() {
    # lib and firmware
    install -d ${D}${libdir}
    find ${S}/bin/${TARGET_ARCH}/Release/lib -name "*.so" -exec install -m 755 {}  ${D}${libdir}/ \;
    find ${S}/bin/${TARGET_ARCH}/Release/lib -name "*.mvcmd" -exec install -m 755 {}  ${D}${libdir}/ \;
    install -m 755 ${S}/bin/${TARGET_ARCH}/Release/lib/plugins.xml   ${D}${libdir}/
    # remove RPATH
    find ${D}${libdir}/ -name "*.so" -exec chrpath -d {} \;
    
    # udev rule
    install -d ${D}/etc/udev/rules.d
    install -m 755 ${S}/inference-engine/thirdparty/movidius/mvnc/src/97-myriad-usbboot.rules   ${D}/etc/udev/rules.d/

    # samples
    install -d ${D}/opt/intel/bin
    find ${S}/bin/${TARGET_ARCH}/Release/ -maxdepth 1 -type f -exec install -m 755 {} ${D}/opt/intel/bin/ \;
    # remove RPATH
    find ${D}/opt/intel/bin -exec chrpath -d {} \;
}

FILES_${PN} += " \
    ${sysconfdir}/udev/rules.d/97-myriad-usbboot.rules \
    ${libdir} \
    /opt/intel \
"
