# Openvino bb file
SUMMARY = "Compilation of Openvino"
DESCRIPTION = "Compile and install Openvino in imx"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "imx8mqevk"
DEPENDS = "opencv libusb1"
RDEPENDS_${PN} = "opencv"

INSANE_SKIP_${PN} = "ldflags"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT  = "1"

SOLIBS = ".so"
FILES_SOLIBSDEV = "${base_libdir}/lib*${SOLIBSDEV} ${libdir}/lib*${SOLIBSDEV} ${prefix}/deployment_tools/inference_engine/lib/aarch64/lib*${SOLIBSDEV}"

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

do_configure_prepend() {
  cd ${S}
  git submodule update --init --recursive
  cd inference-engine/thirdparty/ade/
  git am ${WORKDIR}/0001-Correction-remove-std-move.manualpatch

}

#do_configure () {
#    mkdir -p ${WORKDIR}/buildopenvino
#    cd ${WORKDIR}/buildopenvino
#    pwd
#    cmake ${EXTRA_OECMAKE} -DCMAKE_INSTALL_PREFIX=${WORKDIR}/openvino-install ${S}
#}
    

do_install () {
}
#
#    install -d ${D}${sysconfdir}/udev/rules.d/
#    install -m 755 ${WORKDIR}/97-myriad-usbboot.rules ${D}${sysconfdir}/udev/rules.d/
#
#    install -d ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/libformat_reader.so                       ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/libHeteroPlugin.so                        ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/libinference_engine_c_api.so              ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/libinference_engine_ir_reader.so          ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/libinference_engine_legacy.so             ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/libinference_engine_lp_transformations.so ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/libinference_engine_onnx_reader.so        ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/libinference_engine_preproc.so            ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/libinference_engine.so                    ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/libinference_engine_transformations.so    ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/libMultiDevicePlugin.so                   ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/libmyriadPlugin.so                        ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/libngraph.so                              ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/libonnx_importer.so                       ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/libopencv_c_wraper.so                     ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/plugins.xml                               ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/usb-ma2450.mvcmd                          ${D}${libdir}/
#    install -m 755 ${WORKDIR}/lib/usb-ma2x8x.mvcmd                          ${D}${libdir}/
#}

# FILES_${PN} += " \
#    ${sysconfdir}/udev/rules.d/97-myriad-usbboot.rules \
#\
#    ${libdir}/libformat_reader.so                       \
#    ${libdir}/libHeteroPlugin.so                        \
#    ${libdir}/libinference_engine_c_api.so              \
#    ${libdir}/libinference_engine_ir_reader.so          \
#    ${libdir}/libinference_engine_legacy.so             \
#    ${libdir}/libinference_engine_lp_transformations.so \
#    ${libdir}/libinference_engine_onnx_reader.so        \
#    ${libdir}/libinference_engine_preproc.so            \
#    ${libdir}/libinference_engine.so                    \
#    ${libdir}/libinference_engine_transformations.so    \
#    ${libdir}/libMultiDevicePlugin.so                   \
#    ${libdir}/libmyriadPlugin.so                        \
#    ${libdir}/libngraph.so                              \
#    ${libdir}/libonnx_importer.so                       \
#    ${libdir}/libopencv_c_wraper.so                     \
#    ${libdir}/plugins.xml                               \
#    ${libdir}/usb-ma2450.mvcmd                          \
#    ${libdir}/usb-ma2x8x.mvcmd                          \
#\
#"
