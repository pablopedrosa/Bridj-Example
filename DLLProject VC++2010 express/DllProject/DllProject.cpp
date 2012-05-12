// DllProject.cpp: define las funciones exportadas de la aplicación DLL.
//

#include "stdafx.h"
//#include "DarkGDK.h"

#define DLL extern "C" __declspec(dllexport)

DLL DWORD sum(int a, int b)
{
	return a+b;
}

DLL DWORD changeInt(int &a)
{
	a = 54;
	return 1;
}

DLL int returnCharArr(char *val)
{
	char *valor = "Laura";

	while(*valor != '\0')
		*val++ = *valor++;

	return 2;
}

DLL int completeFunction(int DeviceAddress, int &CurrentAddress, char *SerialNum)
{
	char arr[9] = {122, 126, 36, 58, 69, 70, 71, 72, 73};
	int i =0;

	while(*SerialNum != '\0')
	{
		*SerialNum++ = arr[i];
		i++;
	}

	return 0;
}

DLL DWORD returnCharAst(char *val)
{
	*val ='L';
	return 3;
}