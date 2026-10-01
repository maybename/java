IDE = Integration Development enviroment

# Proměnné a atributy
  proměnná = <ins>pojmenované</ins> políčko v RAM s <ins>typem</ins> a <ins>hodnotou</ins><br>
  atribut = <ins>proměnná</ins> vázaná ke konkrétnímu <ins>objektu</ins>
 - slouží k ukládání dat běžící aplikace (v RAM)

- implicitní inicializace
  - má počáteční hodnotu - př.: ```int x = 5;```
- bez inicializace
  - nemá počáteční hodnotu - př.: ```int x;```

- deklarace atributů
 - uvnitř class - př.: ```private int x;```
 - typy viditelnosti
   - private - viditelné pouze vrámci této class
   - public - viditelné všude

## Datové typy
 - čísla
   - short  - celé číslo menší než int
   - int    - celé číslo
   - long   - celé číslo větší než int
   - float  - desetinné číslo
   - dobble - desetinné číslo s vyšší přesností než float
 - text
   - String - text
 - var - automaticky detekován, vždy musí být implicitně inicializován
 - vlastní datové typy
   - pomocí enum
   ```
   enum Level {
        LOW,
        MEDIUM,
        HIGH
   }
   ```