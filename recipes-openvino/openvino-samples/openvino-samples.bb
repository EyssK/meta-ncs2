# Openvino bb file
SUMMARY = "Load data files for Openvino"
DESCRIPTION = "Load data files for Openvino"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PACKAGE_ARCH = "imx8mqevk"
RDEPENDS_${PN} = "openvino-rules"

SRC_URI += " \
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
    file://FP32/license-plate-recognition-barrier-0001.bin                      \
    file://FP32/vehicle-license-plate-detection-barrier-0106.bin                \
    file://FP32/vehicle-attributes-recognition-barrier-0039.xml                 \
    file://FP32/vehicle-license-plate-detection-barrier-0106.xml                \
    file://FP32/vehicle-attributes-recognition-barrier-0039.bin                 \
    file://FP32/license-plate-recognition-barrier-0001.xml                      \
    file://FP16-INT8/license-plate-recognition-barrier-0001.bin                 \
    file://FP16-INT8/vehicle-license-plate-detection-barrier-0106.bin           \
    file://FP16-INT8/vehicle-attributes-recognition-barrier-0039.xml            \
    file://FP16-INT8/vehicle-license-plate-detection-barrier-0106.xml           \
    file://FP16-INT8/vehicle-attributes-recognition-barrier-0039.bin            \
    file://FP16-INT8/license-plate-recognition-barrier-0001.xml                 \
    file://how_are_you_doing.wav                                                \
"

do_install () {
    install -d ${D}/opt/intel/
    install -d ${D}/opt/intel/FP16
    install -d ${D}/opt/intel/FP32
    install -d ${D}/opt/intel/FP16-INT8
    install -m 755 ${WORKDIR}/car_1.bmp                                                            ${D}/opt/intel/
    install -m 755 ${WORKDIR}/car.png                                                              ${D}/opt/intel/
    install -m 755 ${WORKDIR}/FP16/license-plate-recognition-barrier-0001.bin                      ${D}/opt/intel/FP16/
    install -m 755 ${WORKDIR}/FP16/vehicle-license-plate-detection-barrier-0106.bin                ${D}/opt/intel/FP16/
    install -m 755 ${WORKDIR}/FP16/squeezenet1.1.xml                                               ${D}/opt/intel/FP16/
    install -m 755 ${WORKDIR}/FP16/squeezenet1.1.bin                                               ${D}/opt/intel/FP16/
    install -m 755 ${WORKDIR}/FP16/vehicle-attributes-recognition-barrier-0039.xml                 ${D}/opt/intel/FP16/
    install -m 755 ${WORKDIR}/FP16/vehicle-license-plate-detection-barrier-0106.xml                ${D}/opt/intel/FP16/
    install -m 755 ${WORKDIR}/FP16/vehicle-attributes-recognition-barrier-0039.bin                 ${D}/opt/intel/FP16/
    install -m 755 ${WORKDIR}/FP16/license-plate-recognition-barrier-0001.xml                      ${D}/opt/intel/FP16/
    install -m 755 ${WORKDIR}/FP32/license-plate-recognition-barrier-0001.bin                      ${D}/opt/intel/FP32/
    install -m 755 ${WORKDIR}/FP32/vehicle-license-plate-detection-barrier-0106.bin                ${D}/opt/intel/FP32/
    install -m 755 ${WORKDIR}/FP32/vehicle-attributes-recognition-barrier-0039.xml                 ${D}/opt/intel/FP32/
    install -m 755 ${WORKDIR}/FP32/vehicle-license-plate-detection-barrier-0106.xml                ${D}/opt/intel/FP32/
    install -m 755 ${WORKDIR}/FP32/vehicle-attributes-recognition-barrier-0039.bin                 ${D}/opt/intel/FP32/
    install -m 755 ${WORKDIR}/FP32/license-plate-recognition-barrier-0001.xml                      ${D}/opt/intel/FP32/
    install -m 755 ${WORKDIR}/FP16-INT8/license-plate-recognition-barrier-0001.bin                 ${D}/opt/intel/FP16-INT8/
    install -m 755 ${WORKDIR}/FP16-INT8/vehicle-license-plate-detection-barrier-0106.bin           ${D}/opt/intel/FP16-INT8/
    install -m 755 ${WORKDIR}/FP16-INT8/vehicle-attributes-recognition-barrier-0039.xml            ${D}/opt/intel/FP16-INT8/
    install -m 755 ${WORKDIR}/FP16-INT8/vehicle-license-plate-detection-barrier-0106.xml           ${D}/opt/intel/FP16-INT8/
    install -m 755 ${WORKDIR}/FP16-INT8/vehicle-attributes-recognition-barrier-0039.bin            ${D}/opt/intel/FP16-INT8/
    install -m 755 ${WORKDIR}/FP16-INT8/license-plate-recognition-barrier-0001.xml                 ${D}/opt/intel/FP16-INT8/
    install -m 755 ${WORKDIR}/how_are_you_doing.wav                                                ${D}/opt/intel/
}

FILES_${PN} += "/opt/intel/"
