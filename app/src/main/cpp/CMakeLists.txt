cmake_minimum_required(VERSION 3.4.1)

include_directories(${CMAKE_SOURCE_DIR}/../../../ffmpeg/include)

aux_source_directory(${CMAKE_SOURCE_DIR} SRC)

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


add_library(pushstream SHARED ${SRC})

target_link_libraries(pushstream log ${ffmpeg-lib})