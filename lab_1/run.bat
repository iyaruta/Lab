if not exist "build" mkdir build
if not exist "build\classes" mkdir build\classes
if not exist "docs" mkdir docs

cd src
echo *** Compile classes ***
call javac -d ..\build\classes *.java

echo *** Generete javadoc ***
call javadoc -d ..\docs *.java

echo *** Run PersonRunner ***
cd ..\build\classes
call java -verbose:class PersonRunner
cd ..\..

@echo off
echo.
echo Press any key to exit
pause >nul
exit