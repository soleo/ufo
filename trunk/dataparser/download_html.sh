#!/bin/bash
wget http://www.nuforc.org/webreports/ndxloc.html
#get data
cat ndxloc.html | grep "<TD><FONT style=FONT-SIZE:11pt FACE=\"Calibri\" COLOR=#000000" | awk '{print $6}'| sed 's/[><]/ /' | awk '{print $1}'>pages.txt

cat ndxloc.html | grep "<TD><FONT style=FONT-SIZE:11pt FACE=\"Calibri\" COLOR=#000000" | awk '{print $6,$7,$8}'| sed 's/[><]/ /' | awk '{print $2$3$4}' |sed 's/[<]/ /' |awk '{print $1}' > locationlist.txt

cat ndxloc.html | grep "<TD ALIGN=RIGHT><FONT style=FONT-SIZE:11pt FACE=\"Calibri\" COLOR=#000000" | awk '{print $5}' |sed 's/[><]/ /g' |awk '{print $2}' > numbers.txt

cat locationlist.txt | sed 'R numbers.txt' | sed 'N;s/\n/\t/' > locwithdata.txt

cat pages.txt | sed 's/[a-z]/www.nuforc.org\/webreports\/n/' >urls.txt

xargs -n1 <urls.txt wget --wait=2

