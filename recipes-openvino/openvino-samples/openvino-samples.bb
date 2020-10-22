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
\
    file://hello_query_device                                                   \
    file://car_1.bmp                                                            \
    file://car.png                                                              \
    file://FP16/license-plate-recognition-barrier-0001.bin                      \
    file://FP16/vehicle-license-plate-detection-barrier-0106.bin                \
    file://FP16/squeezenet1.1.xml                                               \
    file://FP16/squeezenet1.1.bin                                               \
    file://FP16/vehicle-attributes-recognition-barrier-0039.xml                 \
    file://FP16/vehicle-license-plate-detection-barrier-0106.xml                \
    file://FP16/vehicle-attributes-recognition-barrier-0039.bin                 \
    file://FP16/license-plate-recognition-barrier-0001.xml                      \
    file://hello_classification_c                                               \
    file://vpu_profile                                                          \
    file://benchmark_app                                                        \
    file://FP32/license-plate-recognition-barrier-0001.bin                      \
    file://FP32/vehicle-license-plate-detection-barrier-0106.bin                \
    file://FP32/vehicle-attributes-recognition-barrier-0039.xml                 \
    file://FP32/vehicle-license-plate-detection-barrier-0106.xml                \
    file://FP32/vehicle-attributes-recognition-barrier-0039.bin                 \
    file://FP32/license-plate-recognition-barrier-0001.xml                      \
    file://style_transfer_sample                                                \
    file://myriad_perfcheck                                                     \
    file://object_detection_sample_ssd_c                                        \
    file://hello_reshape_ssd                                                    \
    file://hello_nv12_input_classification_c                                    \
    file://FP16-INT8/license-plate-recognition-barrier-0001.bin                 \
    file://FP16-INT8/vehicle-license-plate-detection-barrier-0106.bin           \
    file://FP16-INT8/vehicle-attributes-recognition-barrier-0039.xml            \
    file://FP16-INT8/vehicle-license-plate-detection-barrier-0106.xml           \
    file://FP16-INT8/vehicle-attributes-recognition-barrier-0039.bin            \
    file://FP16-INT8/license-plate-recognition-barrier-0001.xml                 \
    file://utils.sh                                                             \
    file://compile_tool                                                         \
    file://hello_classification                                                 \
    file://myriad_compile                                                       \
    file://hello_nv12_input_classification                                      \
    file://classification_sample_async                                          \
    file://how_are_you_doing.wav                                                \
    file://ngraph_function_creation_sample                                      \
    file://speech_sample                                                        \
    file://object_detection_sample_ssd                                          \
    file://demo_security_barrier_camera.sh                                      \
"
#   file://home/security_barrier_camera_demo                                         

do_install () {

    install -d ${D}${base_prefix}/home/root/
    install -d ${D}${base_prefix}/home/root/FP16
    install -d ${D}${base_prefix}/home/root/FP32
    install -d ${D}${base_prefix}/home/root/FP16-INT8
    install -m 755 ${WORKDIR}/hello_query_device                                                   ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/car_1.bmp                                                            ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/car.png                                                              ${D}${base_prefix}/home/root/
    #install -m 755 ${WORKDIR}/security_barrier_camera_demo                                         ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/FP16/license-plate-recognition-barrier-0001.bin                      ${D}${base_prefix}/home/root/FP16/
    install -m 755 ${WORKDIR}/FP16/vehicle-license-plate-detection-barrier-0106.bin                ${D}${base_prefix}/home/root/FP16/
    install -m 755 ${WORKDIR}/FP16/squeezenet1.1.xml                                               ${D}${base_prefix}/home/root/FP16/
    install -m 755 ${WORKDIR}/FP16/squeezenet1.1.bin                                               ${D}${base_prefix}/home/root/FP16/
    install -m 755 ${WORKDIR}/FP16/vehicle-attributes-recognition-barrier-0039.xml                 ${D}${base_prefix}/home/root/FP16/
    install -m 755 ${WORKDIR}/FP16/vehicle-license-plate-detection-barrier-0106.xml                ${D}${base_prefix}/home/root/FP16/
    install -m 755 ${WORKDIR}/FP16/vehicle-attributes-recognition-barrier-0039.bin                 ${D}${base_prefix}/home/root/FP16/
    install -m 755 ${WORKDIR}/FP16/license-plate-recognition-barrier-0001.xml                      ${D}${base_prefix}/home/root/FP16/
    install -m 755 ${WORKDIR}/hello_classification_c                                               ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/vpu_profile                                                          ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/benchmark_app                                                        ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/FP32/license-plate-recognition-barrier-0001.bin                      ${D}${base_prefix}/home/root/FP32/
    install -m 755 ${WORKDIR}/FP32/vehicle-license-plate-detection-barrier-0106.bin                ${D}${base_prefix}/home/root/FP32/
    install -m 755 ${WORKDIR}/FP32/vehicle-attributes-recognition-barrier-0039.xml                 ${D}${base_prefix}/home/root/FP32/
    install -m 755 ${WORKDIR}/FP32/vehicle-license-plate-detection-barrier-0106.xml                ${D}${base_prefix}/home/root/FP32/
    install -m 755 ${WORKDIR}/FP32/vehicle-attributes-recognition-barrier-0039.bin                 ${D}${base_prefix}/home/root/FP32/
    install -m 755 ${WORKDIR}/FP32/license-plate-recognition-barrier-0001.xml                      ${D}${base_prefix}/home/root/FP32/
    install -m 755 ${WORKDIR}/style_transfer_sample                                                ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/myriad_perfcheck                                                     ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/object_detection_sample_ssd_c                                        ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/hello_reshape_ssd                                                    ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/hello_nv12_input_classification_c                                    ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/FP16-INT8/license-plate-recognition-barrier-0001.bin                 ${D}${base_prefix}/home/root/FP16-INT8/
    install -m 755 ${WORKDIR}/FP16-INT8/vehicle-license-plate-detection-barrier-0106.bin           ${D}${base_prefix}/home/root/FP16-INT8/
    install -m 755 ${WORKDIR}/FP16-INT8/vehicle-attributes-recognition-barrier-0039.xml            ${D}${base_prefix}/home/root/FP16-INT8/
    install -m 755 ${WORKDIR}/FP16-INT8/vehicle-license-plate-detection-barrier-0106.xml           ${D}${base_prefix}/home/root/FP16-INT8/
    install -m 755 ${WORKDIR}/FP16-INT8/vehicle-attributes-recognition-barrier-0039.bin            ${D}${base_prefix}/home/root/FP16-INT8/
    install -m 755 ${WORKDIR}/FP16-INT8/license-plate-recognition-barrier-0001.xml                 ${D}${base_prefix}/home/root/FP16-INT8/
    install -m 755 ${WORKDIR}/utils.sh                                                             ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/compile_tool                                                         ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/hello_classification                                                 ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/myriad_compile                                                       ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/hello_nv12_input_classification                                      ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/classification_sample_async                                          ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/how_are_you_doing.wav                                                ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/ngraph_function_creation_sample                                      ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/speech_sample                                                        ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/object_detection_sample_ssd                                          ${D}${base_prefix}/home/root/
    install -m 755 ${WORKDIR}/demo_security_barrier_camera.sh                                      ${D}${base_prefix}/home/root/
}

FILES_${PN} += " \
\
    ${base_prefix}/home/root/                                                                     \
    ${base_prefix}/home/root/hello_query_device                                                   \
    ${base_prefix}/home/root/car_1.bmp                                                            \
    ${base_prefix}/home/root/car.png                                                              \
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
