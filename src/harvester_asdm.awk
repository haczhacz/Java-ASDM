#ssconvert XLS_FILE OUTPUT_FILE
#awk -f test.awk asdms.csv> asdm_f.csv
BEGIN {
	FS = "~"
	OFS = "\t"
}
NR > 1{
	print $2,$34,$39,$49
}


#	2 uid
#	34 fov
#	39 redshift
# 	49 resolving power
