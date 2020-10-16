# Openvino bb file
SUMMARY = "Compilation of Openvino"
DESCRIPTION = "Compile and install Openvino in imx."
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
FILES_SOLIBSDEV = ""

SRC_URI += " \
    file://97-myriad-usbboot.rules                   \
\
    file://lib/libformat_reader.so                       \
    file://lib/libHeteroPlugin.so                        \
    file://lib/libinference_engine_c_api.so              \
    file://lib/libinference_engine_ir_reader.so          \
    file://lib/libinference_engine_legacy.so             \
    file://lib/libinference_engine_lp_transformations.so \
    file://lib/libinference_engine_onnx_reader.so        \
    file://lib/libinference_engine_preproc.so            \
    file://lib/libinference_engine.so                    \
    file://lib/libinference_engine_transformations.so    \
    file://lib/libMultiDevicePlugin.so                   \
    file://lib/libmvnc.so                                \
    file://lib/libmyriadPlugin.so                        \
    file://lib/libngraph.so                              \
    file://lib/libonnx_importer.so                       \
    file://lib/libopencv_c_wraper.so                     \
    file://lib/libtemplate_extension.so                  \
    file://lib/libtemplatePlugin.so                      \
    file://lib/libXLink.so                               \
    file://lib/plugins.xml                               \
    file://lib/usb-ma2450.mvcmd                          \
    file://lib/usb-ma2x8x.mvcmd                          \
\
    file://home/hello_query_device                                                   \
    file://home/car_1.bmp                                                            \
    file://home/car.png                                                              \
    file://home/security_barrier_camera_demo                                         \
    file://home/FP16/license-plate-recognition-barrier-0001.bin                      \
    file://home/FP16/vehicle-license-plate-detection-barrier-0106.bin                \
    file://home/FP16/squeezenet1.1.xml                                               \
    file://home/FP16/squeezenet1.1.bin                                               \
    file://home/FP16/vehicle-attributes-recognition-barrier-0039.xml                 \
    file://home/FP16/vehicle-license-plate-detection-barrier-0106.xml                \
    file://home/FP16/vehicle-attributes-recognition-barrier-0039.bin                 \
    file://home/FP16/license-plate-recognition-barrier-0001.xml                      \
    file://home/hello_classification_c                                               \
    file://home/vpu_profile                                                          \
    file://home/benchmark_app                                                        \
    file://home/FP32/license-plate-recognition-barrier-0001.bin                      \
    file://home/FP32/vehicle-license-plate-detection-barrier-0106.bin                \
    file://home/FP32/vehicle-attributes-recognition-barrier-0039.xml                 \
    file://home/FP32/vehicle-license-plate-detection-barrier-0106.xml                \
    file://home/FP32/vehicle-attributes-recognition-barrier-0039.bin                 \
    file://home/FP32/license-plate-recognition-barrier-0001.xml                      \
    file://home/style_transfer_sample                                                \
    file://home/myriad_perfcheck                                                     \
    file://home/object_detection_sample_ssd_c                                        \
    file://home/hello_reshape_ssd                                                    \
    file://home/hello_nv12_input_classification_c                                    \
    file://home/FP16-INT8/license-plate-recognition-barrier-0001.bin                 \
    file://home/FP16-INT8/vehicle-license-plate-detection-barrier-0106.bin           \
    file://home/FP16-INT8/vehicle-attributes-recognition-barrier-0039.xml            \
    file://home/FP16-INT8/vehicle-license-plate-detection-barrier-0106.xml           \
    file://home/FP16-INT8/vehicle-attributes-recognition-barrier-0039.bin            \
    file://home/FP16-INT8/license-plate-recognition-barrier-0001.xml                 \
    file://home/utils.sh                                                             \
    file://home/compile_tool                                                         \
    file://home/hello_classification                                                 \
    file://home/myriad_compile                                                       \
    file://home/hello_nv12_input_classification                                      \
    file://home/classification_sample_async                                          \
    file://home/how_are_you_doing.wav                                                \
    file://home/ngraph_function_creation_sample                                      \
    file://home/speech_sample                                                        \
    file://home/object_detection_sample_ssd                                          \
    file://home/demo_security_barrier_camera.sh                                      \
"

do_install () {

    install -d ${D}${sysconfdir}/udev/rules.d/
    install -m 755 ${WORKDIR}/97-myriad-usbboot.rules ${D}${sysconfdir}/udev/rules.d/

    install -d ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libformat_reader.so                       ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libHeteroPlugin.so                        ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libinference_engine_c_api.so              ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libinference_engine_ir_reader.so          ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libinference_engine_legacy.so             ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libinference_engine_lp_transformations.so ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libinference_engine_onnx_reader.so        ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libinference_engine_preproc.so            ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libinference_engine.so                    ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libinference_engine_transformations.so    ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libMultiDevicePlugin.so                   ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libmvnc.so                                ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libmyriadPlugin.so                        ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libngraph.so                              ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libonnx_importer.so                       ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libopencv_c_wraper.so                     ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libtemplate_extension.so                  ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libtemplatePlugin.so                      ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/libXLink.so                               ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/plugins.xml                               ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/usb-ma2450.mvcmd                          ${D}${libdir}/
    install -m 755 ${WORKDIR}/lib/usb-ma2x8x.mvcmd                          ${D}${libdir}/

    install -d ${D}${base_prefix}/home/root/
    install -d ${D}${base_prefix}/home/root/FP16
    install -d ${D}${base_prefix}/home/root/FP32
    install -d ${D}${base_prefix}/home/root/FP16-INT8
    install -m 755 ${WORKDIR}/home/hello_query_device                                                   ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/car_1.bmp                                                            ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/car.png                                                              ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/security_barrier_camera_demo                                         ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/FP16/license-plate-recognition-barrier-0001.bin                      ${D}${base_prefix}/home/root/FP16/
    install -m 755 ${WORKDIR}/home/FP16/vehicle-license-plate-detection-barrier-0106.bin                ${D}${base_prefix}/home/root/FP16/
    install -m 755 ${WORKDIR}/home/FP16/squeezenet1.1.xml                                               ${D}${base_prefix}/home/root/FP16/
    install -m 755 ${WORKDIR}/home/FP16/squeezenet1.1.bin                                               ${D}${base_prefix}/home/root/FP16/
    install -m 755 ${WORKDIR}/home/FP16/vehicle-attributes-recognition-barrier-0039.xml                 ${D}${base_prefix}/home/root/FP16/
    install -m 755 ${WORKDIR}/home/FP16/vehicle-license-plate-detection-barrier-0106.xml                ${D}${base_prefix}/home/root/FP16/
    install -m 755 ${WORKDIR}/home/FP16/vehicle-attributes-recognition-barrier-0039.bin                 ${D}${base_prefix}/home/root/FP16/
    install -m 755 ${WORKDIR}/home/FP16/license-plate-recognition-barrier-0001.xml                      ${D}${base_prefix}/home/root/FP16/
    install -m 755 ${WORKDIR}/home/hello_classification_c                                               ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/vpu_profile                                                          ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/benchmark_app                                                        ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/FP32/license-plate-recognition-barrier-0001.bin                      ${D}${base_prefix}/home/root/FP32/
    install -m 755 ${WORKDIR}/home/FP32/vehicle-license-plate-detection-barrier-0106.bin                ${D}${base_prefix}/home/root/FP32/
    install -m 755 ${WORKDIR}/home/FP32/vehicle-attributes-recognition-barrier-0039.xml                 ${D}${base_prefix}/home/root/FP32/
    install -m 755 ${WORKDIR}/home/FP32/vehicle-license-plate-detection-barrier-0106.xml                ${D}${base_prefix}/home/root/FP32/
    install -m 755 ${WORKDIR}/home/FP32/vehicle-attributes-recognition-barrier-0039.bin                 ${D}${base_prefix}/home/root/FP32/
    install -m 755 ${WORKDIR}/home/FP32/license-plate-recognition-barrier-0001.xml                      ${D}${base_prefix}/home/root/FP32/
    install -m 755 ${WORKDIR}/home/style_transfer_sample                                                ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/myriad_perfcheck                                                     ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/object_detection_sample_ssd_c                                        ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/hello_reshape_ssd                                                    ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/hello_nv12_input_classification_c                                    ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/FP16-INT8/license-plate-recognition-barrier-0001.bin                 ${D}${base_prefix}/home/root/FP16-INT8/
    install -m 755 ${WORKDIR}/home/FP16-INT8/vehicle-license-plate-detection-barrier-0106.bin           ${D}${base_prefix}/home/root/FP16-INT8/
    install -m 755 ${WORKDIR}/home/FP16-INT8/vehicle-attributes-recognition-barrier-0039.xml            ${D}${base_prefix}/home/root/FP16-INT8/
    install -m 755 ${WORKDIR}/home/FP16-INT8/vehicle-license-plate-detection-barrier-0106.xml           ${D}${base_prefix}/home/root/FP16-INT8/
    install -m 755 ${WORKDIR}/home/FP16-INT8/vehicle-attributes-recognition-barrier-0039.bin            ${D}${base_prefix}/home/root/FP16-INT8/
    install -m 755 ${WORKDIR}/home/FP16-INT8/license-plate-recognition-barrier-0001.xml                 ${D}${base_prefix}/home/root/FP16-INT8/
    install -m 755 ${WORKDIR}/home/utils.sh                                                             ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/compile_tool                                                         ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/hello_classification                                                 ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/myriad_compile                                                       ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/hello_nv12_input_classification                                      ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/classification_sample_async                                          ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/how_are_you_doing.wav                                                ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/ngraph_function_creation_sample                                      ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/speech_sample                                                        ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/object_detection_sample_ssd                                          ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/home/demo_security_barrier_camera.sh                                      ${D}${base_prefix}/home/root/
}

FILES_${PN} += " \
    ${sysconfdir}/udev/rules.d/97-myriad-usbboot.rules \
\
    ${libdir}                                           \
    ${libdir}/libformat_reader.so                       \
    ${libdir}/libHeteroPlugin.so                        \
    ${libdir}/libinference_engine_c_api.so              \
    ${libdir}/libinference_engine_ir_reader.so          \
    ${libdir}/libinference_engine_legacy.so             \
    ${libdir}/libinference_engine_lp_transformations.so \
    ${libdir}/libinference_engine_onnx_reader.so        \
    ${libdir}/libinference_engine_preproc.so            \
    ${libdir}/libinference_engine.so                    \
    ${libdir}/libinference_engine_transformations.so    \
    ${libdir}/libMultiDevicePlugin.so                   \
    ${libdir}/libmvnc.so                                \
    ${libdir}/libmyriadPlugin.so                        \
    ${libdir}/libngraph.so                              \
    ${libdir}/libonnx_importer.so                       \
    ${libdir}/libopencv_c_wraper.so                     \
    ${libdir}/libtemplate_extension.so                  \
    ${libdir}/libtemplatePlugin.so                      \
    ${libdir}/libXLink.so                               \
    ${libdir}/plugins.xml                               \
    ${libdir}/usb-ma2450.mvcmd                          \
    ${libdir}/usb-ma2x8x.mvcmd                          \
\
    ${base_prefix}/home/root/                                                                     \
    ${base_prefix}/home/root/hello_query_device                                                   \
    ${base_prefix}/home/root/car_1.bmp                                                            \
    ${base_prefix}/home/root/car.png                                                              \
    ${base_prefix}/home/root/security_barrier_camera_demo                                         \
    ${base_prefix}/home/root/FP16/license-plate-recognition-barrier-0001.bin                      \
    ${base_prefix}/home/root/FP16/vehicle-license-plate-detection-barrier-0106.bin                \
    ${base_prefix}/home/root/FP16/squeezenet1.1.xml                                               \
    ${base_prefix}/home/root/FP16/squeezenet1.1.bin                                               \
    ${base_prefix}/home/root/FP16/vehicle-attributes-recognition-barrier-0039.xml                 \
    ${base_prefix}/home/root/FP16/vehicle-license-plate-detection-barrier-0106.xml                \
    ${base_prefix}/home/root/FP16/vehicle-attributes-recognition-barrier-0039.bin                 \
    ${base_prefix}/home/root/FP16/license-plate-recognition-barrier-0001.xml                      \
    ${base_prefix}/home/root/hello_classification_c                                               \
    ${base_prefix}/home/root/vpu_profile                                                          \
    ${base_prefix}/home/root/benchmark_app                                                        \
    ${base_prefix}/home/root/FP32/license-plate-recognition-barrier-0001.bin                      \
    ${base_prefix}/home/root/FP32/vehicle-license-plate-detection-barrier-0106.bin                \
    ${base_prefix}/home/root/FP32/vehicle-attributes-recognition-barrier-0039.xml                 \
    ${base_prefix}/home/root/FP32/vehicle-license-plate-detection-barrier-0106.xml                \
    ${base_prefix}/home/root/FP32/vehicle-attributes-recognition-barrier-0039.bin                 \
    ${base_prefix}/home/root/FP32/license-plate-recognition-barrier-0001.xml                      \
    ${base_prefix}/home/root/style_transfer_sample                                                \
    ${base_prefix}/home/root/myriad_perfcheck                                                     \
    ${base_prefix}/home/root/object_detection_sample_ssd_c                                        \
    ${base_prefix}/home/root/hello_reshape_ssd                                                    \
    ${base_prefix}/home/root/hello_nv12_input_classification_c                                    \
    ${base_prefix}/home/root/FP16-INT8/license-plate-recognition-barrier-0001.bin                 \
    ${base_prefix}/home/root/FP16-INT8/vehicle-license-plate-detection-barrier-0106.bin           \
    ${base_prefix}/home/root/FP16-INT8/vehicle-attributes-recognition-barrier-0039.xml            \
    ${base_prefix}/home/root/FP16-INT8/vehicle-license-plate-detection-barrier-0106.xml           \
    ${base_prefix}/home/root/FP16-INT8/vehicle-attributes-recognition-barrier-0039.bin            \
    ${base_prefix}/home/root/FP16-INT8/license-plate-recognition-barrier-0001.xml                 \
    ${base_prefix}/home/root/utils.sh                                                             \
    ${base_prefix}/home/root/compile_tool                                                         \
    ${base_prefix}/home/root/hello_classification                                                 \
    ${base_prefix}/home/root/myriad_compile                                                       \
    ${base_prefix}/home/root/hello_nv12_input_classification                                      \
    ${base_prefix}/home/root/classification_sample_async                                          \
    ${base_prefix}/home/root/how_are_you_doing.wav                                                \
    ${base_prefix}/home/root/ngraph_function_creation_sample                                      \
    ${base_prefix}/home/root/speech_sample                                                        \
    ${base_prefix}/home/root/object_detection_sample_ssd                                          \
    ${base_prefix}/home/root/demo_security_barrier_camera.sh                                      \
"
