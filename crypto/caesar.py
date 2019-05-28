from helpers import alphabet_position, rotate_character                         
def encrypt(text, rot):
    encrypt_string = ""    
    for character in text:
        letter = rotate_character(character,rot)
        encrypt_string += letter
    return encrypt_string

def main():
    text = input("What message do you want to encrypt? ")
    rot = int(input("How far should it rotate? "))
    
    
    
if __name__ == "__main__": 
    main()
    