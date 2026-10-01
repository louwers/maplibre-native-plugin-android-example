cmake_minimum_required(VERSION 3.22)
project(MapLibreNgonPlugin LANGUAGES CXX)

# The published AAR supplies the public C ABI through Prefab. No SDK checkout needed.
find_package(MapLibreAndroid REQUIRED CONFIG)
get_filename_component(NGON_ROOT "${CMAKE_CURRENT_SOURCE_DIR}/../../.." ABSOLUTE)
add_subdirectory("${NGON_ROOT}" ngon-layer)
target_link_libraries(mln-ngon-layer PUBLIC MapLibreAndroid::maplibre)

add_library(ngon-plugin SHARED plugin.cpp)
target_link_libraries(ngon-plugin PRIVATE mln-ngon-layer dl)
