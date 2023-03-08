## Zadání
Napište program, který bude vystavovat REST službu, která na vstupu bude dostávat číslo. Služba s číslem provede výpočet a vrátí zpět.
Výpočet provede postupně takto:
- všechny číslice menší 3 (včetně) posune o jednu pozici doprava. Např: 43256791 => 45326791
- všechny číslice 8 a 9 vynásobí 2. Např.: 45326791 => 453267181
- všechny číslice 7 smaže: Např: 453267181 => 45326181
- ve výsledném čísle spočte počet sudých číslic a tímto počtem výsledné číslo vydělí a zaokrouhlí dolů na celá čísla. Např: 45326181 / 4 => 11331545

Pro zadané číslo 43256791 je výsledek 11331545.


## Predpoklady
 Vyradil jsem negativni cisla. Byt by se s nimi dalo ignorovat znamenka a zpracovat totozne, neni o nich zminka.


## Dojmy
Selhals jsem v:
 - dodrzeni casu
 - overengineeringu
 -  ???
