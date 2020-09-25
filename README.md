# CSV file converter

This converts a CSV from multiline (e.g. a CSV file with newlines quoted inside of fields) to one-line-per-record with `<br/>` replacing newlines inside of fields.

cat mycsv.csv | java -jar the-jar.jar >fixed-mycsv.csv

That should do it.
