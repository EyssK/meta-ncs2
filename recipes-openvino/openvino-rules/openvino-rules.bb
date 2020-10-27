# Openvino bb file
SUMMARY = "Compilation of Openvino"
DESCRIPTION = "Compile and install Openvino in imx"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "imx8mqevk"
DEPENDS = "opencv libusb1"
RDEPENDS_${PN} = "opencv bash"

INSANE_SKIP_${PN} += "already-stripped"
INSANE_SKIP_${PN} += "staticdev"

inherit pkgconfig cmake
SRCREV = "ac65ea30fd90ec04bcf9a3c326f846d8f86f516d"
SRC_URI += " \
    git://github.com/openvinotoolkit/openvino;protocol=https \
    file://0001-Correction-remove-std-move.manualpatch   \
"
EXTRA_OECMAKE = "-DCMAKE_BUILD_TYPE=Release -DENABLE_SSE42=OFF -DTHREADING=SEQ -DENABLE_GNA=OFF -DCMAKE_INSTALL_PREFIX=/opt/intel"
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

FILES_${PN} += "/opt/intel/"
