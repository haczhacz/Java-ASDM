#ssconvert XLS_FILE OUTPUT_FILE
#awk -f test.awk asdms.csv> asdm_f.csv
BEGIN {
	FS = ","
	OFS = ","
}
NR > 1{
	print $2,$34,$49
}


#	2 uid
#	34 fov
# 	49 resolving power
