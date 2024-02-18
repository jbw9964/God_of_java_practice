@echo off

@REM Usage: get_package_name.bat <relative_path_to_java_file>

set "java_file=%1%"

@REM Convert path separators to dots
set "package_name=%java_file:\=.%"

@REM Remove ".java" extension
set "package_name=%package_name:.java=%"

echo %package_name%
