#!/bin/sh

for file in `cat pages.txt`
	do
		`cat $file | grep "<FONT style=FONT-SIZE:11pt FACE=\"Calibri\" COLOR=#000000>" | sed 's/<TD bgcolor=\"#FFFFCC" /<TD/' |sed 's/<TD><FONT style=FONT-SIZE:11pt FACE="Calibri" COLOR=#000000>//' | sed 's/<\/TD>/ /' | sed 's/<[^>]*>//g' > ${file%.html}".txt"`
		done

rm *.html
