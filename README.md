Run on Powershell:
flex lexer.l
gcc lex.yy.c -o exe -L"C:\Program Files (x86)\GnuWin32\lib" -lfl
Get-Content input_file.txt | ./exe

Note: this should only work on powershell and the location for the GnuWin32/lib should be your own.

![alt text](C:\Users\Administrator\Downloads\readme.png)
