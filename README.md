# YAL_compiler
School project: YAL compiler (Yet Another Language)

## Usage
`~$ java -jar Yal.jar source_code.yal` will generate a `.mips` file.


Errors will be displayed with lines and columns in the terminal.


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

## Authors
* [Jonathan Schmitt](https://github.com/kaysou)
* [Pierre Bouillon](https://pierrebouillon.tech/)
* [Yoan Fath](https://github.com/yoanFath)
