if [ -z "$var" ]; then
    FP=FP16
fi
./security_barrier_camera_demo -d MYRIAD -d_va MYRIAD -d_lpr MYRIAD -i car_1.bmp -m ${FP}/vehicle-license-plate-detection-barrier-0106.xml -m_lpr ${FP}/license-plate-recognition-barrier-0001.xml -m_va ${FP}/vehicle-attributes-recognition-barrier-0039.xml
