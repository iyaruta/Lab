if not exist "build" mkdir build
if not exist "build\classes" mkdir build\classes
if not exist "docs" mkdir docs
if not exist "lib" mkdir lib

cd src
echo *** Compile classes ***
call javac -sourcepath . -d ..\build\classes ua\kpi\pti\HelloWorld.java

echo *** Generete javadoc ***
call javadoc -d ..\docs -sourcepath .\ -subpackages . *
cd ..

echo *** Run Java ***
cd build\classes
call java -verbose:class ua.kpi.pti.HelloWorld

echo *** Create JAR ***
call jar -cvfe ..\..\lib\lab3.jar ua.kpi.pti.HelloWorld .

cd ..\..
echo *** Run JAR ***
call java -jar lib\lab3.jar

@echo off
echo.
echo Press any key to exit
pause >nul
exit