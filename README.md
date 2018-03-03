# YAL_compiler
School project: YAL compiler (Yet Another Language)

## Usage
`~$ java -jar Yal.jar source_code.yal` will generate a `.mips` file.


Errors will be displayed with lines and columns in the terminal. 

If everything is fine, you should see `COMPILATION OK` in your console prompt.


## Yal sample
```
programme YALsample debut

    // declarations
    entier someVar ;
    entier someOtherVar ;
    
    // core
    ecrire "Your number: " ;
    lire someVar ;
    
    someOtherVar = 0 ;
    si someVar > 0 alors
        tantque someVar > someOtherVar repeter
            someVar = someVar + 1 ;
        fintantque
    sinon
        tantque someVar < someOtherVar repeter
            someVar = someVar - 1 ;
        fintantque
    fsi
    
    ecrire "Steps: " ;
    ecrire someOtherVar ;
        
fin
```

Compilation will be:
```shell
~$java -jar yal.jar YALsample.yal
COMPILATION_OK
```

## MIPS

### Running MIPS
Run MIPS with [MARS](http://courses.missouristate.edu/KenVollmar/MARS/download.htm)

### Learning more about MIPS
Documentation available [here](https://www.cs.cornell.edu/courses/cs3410/2008fa/MIPS_Vol2.pdf) or summary [here](http://www.mrc.uidaho.edu/mrc/people/jff/digital/MIPSir.html)

## Authors
* [Jonathan Schmitt](https://github.com/kaysou)
* [Pierre Bouillon](https://pierrebouillon.tech/)
* [Yoan Fath](https://github.com/yoanFath)
