def alphabet_position(letter):
    char = ''
    if letter.isalpha():
        if letter == letter.lower():
             num = (ord(letter) - 97) % 26
             return num 
        if letter == letter.upper():
             num = (ord(letter) - 65) % 26
             return num
        elif letter != letter.isalpha():
             char += letter
             return char

def rotate_character(char,rot):
    character = ''
    if char.isalpha() == False:
        char += character
        return char
    else:  
        rot = alphabet_position(char) + rot
        if rot >= 26:
            rot -= 26
        if char == char.upper():
            rot += 65
        if char == char.lower():
            rot += 97
        return chr(rot) 
    
	    


