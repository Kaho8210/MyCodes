import os
import sys
import fileinput
# from nltk.tokenize import WhitespaceTokenizer
#try with pycontractions
import contractions 
import re


with open('file.txt', 'w') as output_file:
    with open('demofile.txt', 'r') as file :
        result = string.replace("/","")
        output_file.write(" ".join(result))       