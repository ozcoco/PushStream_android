cmake_minimum_required(VERSION 3.4.1)

include_directories(
        ${CMAKE_SOURCE_DIR}/../../../ffmpeg/include
        ${CMAKE_SOURCE_DIR}/../../../opencv/include)

aux_source_directory(${CMAKE_SOURCE_DIR} SRC)


#ffmpeg 4.0.4
set(ffmpeg-dir ../../../ffmpeg/${ANDROID_ABI})

link_directories(${ffmpeg-dir})

set(ffmpeg-lib
        avcodec-58
        avdevice-58
        avfilter-7
        avformat-58
        avutil-56
        postproc-55
        swresample-3
        swscale-5)


#opencv 4
set(opencv-dir ../../../opencv)

link_directories(
        ${opencv-dir}/3rdparty/${ANDROID_ABI}
        ${opencv-dir}/staticlibs/${ANDROID_ABI})

set(opencv-lib
        #opencv
        opencv_calib3d
        opencv_core
        opencv_dnn
        opencv_features2d
        opencv_flann
        opencv_highgui
        opencv_imgcodecs
        opencv_imgproc
        opencv_ml
        opencv_objdetect
        opencv_photo
        opencv_stitching
        opencv_video
        opencv_videoio
        #opencv 3rdpart
        cpufeatures
        IlmImf
        ittnotify
        libjasper
        libjpeg-turbo
        libpng
        libprotobuf
        libtiff
        libwebp
        quirc
        tbb
        #tegra_hal
        )

add_library(pushstream SHARED ${SRC})

target_link_libraries(pushstream log ${ffmpeg-lib} ${opencv-lib})