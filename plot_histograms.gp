# Gnuplot script for creating histograms with a limited address range

# Set the output format and size
set term pngcairo enhanced
set size 1,0.5

# Set the address range you want to include in the histogram
# Adjust the range as needed, e.g., 
set xrange [0:4000]
set yrange [0:25000]

# Create the first histogram for cc1_filtered_data.txt
set output "cc1_histogram.png"
set title "CC Compiler Trace Address Distribution (Filtered)"
set xlabel "Address (Decimal)"
set ylabel "Occurrences"
set style fill solid

plot 'cc1_data.txt' using 1:2 with boxes

set output "spice_histogram.png"
set title "SPICE Simulator Trace Address Distribution (Filtered)"
set xlabel "Address (Decimal)"
set ylabel "Occurrences"
set style fill solid
plot 'spice_data.txt' using 1:2 with boxes
