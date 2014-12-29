Jumper
======
Igrica Jumper. Igrač dobija jednu figuru koja se kreće po zelenoj podlozi. Na pritisak bilo koje tipke 
na tastaturi, figura skače uvis. Cilj igre je pomoću skoka izbjeći sve prepreke na koje figura može naići.
Za svaku prekočenu figuru igrač dobija jedan bod. Ukoliko se figura sudari sa preprekom, igra je gotova.

Igračeva figura je tipa Oval, a prepreke tipa Rect, s tim da obe klase nasljeđuju Body. U klasi Body se koriste
dvije tačke (objekti tipa Point sa x i y koordinatama). Prva tačka je start koja predstavlja početnu tačku crtanja objekta. 
Druga tačka je center, središnja tačka objekta. U klasi Body još imamo metode move(), koje koriste brzino po x i y osama, kako bi 
omogućili kretanje objekta, i metodu jump() koja omogućava skok. U klasi GameGraphics kreiramo niz od 10 prepreka koje iscrtavamo 
pomoću petlje i dajemo im random brzine i dimenzije. Crtamo i zelenu podlogu i igračevu figuru. Zatim pomoću KeyAdaptera 
pozivamo jump() metodu za igračevu figuru. U klasi Play imamo main funkciju u kojoj kreiramo prozor i panel (koji je tipa 
GameGraphics), zatim panel "lijepimo" na prozor i dodajemo mu fokus.
