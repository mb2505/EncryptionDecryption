# EncryptionDecryption
Today, encryption and decryption algorithms are used everywhere on the Internet to protect our data. This is especially important for sites 
that handle sensitive data, such as e-commerce sites that accept online card payments and login areas that require users to enter their credentials. 
To ensure data security, there are complex encryption algorithms behind the scenes. This project, encrypts and decrypts messages and texts using simple algorithms. 
Please note that such algorithms are not suitable for industrial use because they can easily be cracked, but these algorithms demonstrate some general 
ideas about encryption.

This program works with command-line arguments. 
It reads data from the command line or from a file and encrypts/decrypts the text using the "Shift" algorithm
or the "Unicode" Algorithm.

The program reads data from -data or from a file written in the -in argument. 
That's why you can't have both -data and -in arguments simultaneously, only one of them.

If there is no -mode, the program works in encryption mode.
If there is no -key, the program considers that key = 0.
If there is no -data, and there is no -in the program assumes that the data is an empty string.
If there is no -out argument, the program prints data to the standard output.
If there are both -data and -in arguments, the program prefers -data over -in.
If there is no -alg the default algorithm is "shift".

Examples:

Example 1

java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode
This command gets data from the file road_to_treasure.txt, encrypts the data with the key 5, creates a file called protected.txt and writes ciphertext to it.

Example 2

Input:

java Main -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode
Output:

\jqhtrj%yt%m~ujwxpnqq&
Example 3

Input:

java Main -key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec
Output:

Welcome to hyperskill!
Example 4:

Input:

java Main -key 5 -alg shift -data "Welcome to hyperskill!" -mode enc
Output:

Bjqhtrj yt mdujwxpnqq!
Example 5:

Input:

java Main -key 5 -alg shift -data "Bjqhtrj yt mdujwxpnqq!" -mode dec
Output:

Welcome to hyperskill!
