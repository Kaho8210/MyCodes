data
N: .word 4 #32 bit loop

A: .word 0 #A[0][0]
.word 0 #A[0][1]
.word 0
.word 1
.word 0 #A[1][0]
.word 2 #A[1][1]
.word 0 #A[1][2]
.word 0
.word 0 #A[2][0]
.word 0 #A[2][1]
.word 3
.word 0
.word 4 #A[3][0]
.word 0
.word 0
.word 0

B: .word 0 #B[0][0]
.word 1 #B[0][1]
.word 2
.word 3
.word 4 #B[1][0]
.word 5
.word 6
.word 7 #B[1][3]
.word 8
.word 9
.word 10
.word 11 #B[2][3]
.word 12 #B[4][0]
.word 13
.word 14
.word 15

S: .word 0 #S[0][0]
.word 0 #S[0][1]
.word 0
.word 0
.word 0 #S[1][0]
.word 0
.word 0
.word 0 #S[1][3]
.word 0
.word 0
.word 0
.word 0 #S[2][3]
.word 0 #S[4][0]
.word 0
.word 0
.word 0

.text
main: lw $4,A #multiplicand
lw $5,B #multiplier
lw $2,S

ori $16,$0,0     #i=0
ori $17,$0,0     #j=0
ori $18,$0,0     #k=0
ori $19,$0,4     #$19=4
ori $21,$0,0
ori $22,$0,0          
ori $23,$0,0
loopi: beq $16,$19,fori #if i==4, go to fori

loopj: beq $17,$19,forj #if j==4, go to forj
ori $20,$0,0 #s==0

loopk: beq $18,$19,fork #if k==4, go to fork

lw $4,A($21)        #$4=A[i+4]
lw  $5,B($23)	    #$5=B[j+16]
addi $21,$21,4         #i=i+4 for 4 byte (multiplicand A[])
addi $23,$23,16        #j=j+16 for 16 byte (multiplier B[])

jal subroutine       #call product   multiplication result of $4 and $5 is in $2
add $20,$20,$2        #s += mat1[i][k] * mat2[k][j]
addi $18,$18,1        #k++
j loopk
fork: sw $20, S($22) #result[i][j] = s
addi $22,$22,4 # S[i+4]
addi $21,$21,-16 #after k, go back to row
addi $23,$23,-60 #after k, go to next column
ori $18,$0,0 #initialize counter
addi $17,$17,1 #j++
j loopj

forj: ori $17,$0,0 #j=0 #initialize counter
addi $16,$16,1 #i++
addi $21,$21,16 #after k, go to next row
ori $23,$0,0 #reset column
j loopi

fori: addi $21,$21,16 #A[i+16] A[i]が終わったら次の行に
j fin

#DO NOT CHANGE#

subroutine: lw $8,N #load N
ori $2,$0,0 #product resister
addi $9,$0,0 #i=0
addi $10,$0,1 #for left shift
add $11,$0,$4 #for left shift, $11=multiplicand

loop: beq $8,$9,loopend #if i==N,
and $12,$10,$5 # B & left shift
beq $12,$0,iszero #if (B & left shift)==0 (->if next bit of multiplier is 0),go to iszero
add $2,$2,$11 #product = product + multiplicand

iszero: addu $10,$10,$10 #$10=1+1 ->left shift
addu $11,$11,$11 #move multiplicand to left
addi $9,$9,1 #i=i+1
j loop

loopend: jr $31 #return to the procedure, $31 saves the value of jal program counter

fin: j exit
