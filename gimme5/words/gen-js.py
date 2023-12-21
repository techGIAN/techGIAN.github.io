import os

folder_path = './'  # Replace with the actual path to your folder

txt_files_in_folder = [f for f in os.listdir(folder_path) if f.endswith('.txt') and f[0] != '.']

for txt_file in txt_files_in_folder:
    
    cat = txt_file.split('.')[0]
    with open(txt_file, 'r') as f:
        content = f.read()
    
    arr = content.split('\n')
    arr = ['"' + word.upper() + '"' for word in arr]
    s = 'var ' + cat + '_list = [' + ', '.join(arr) + '];'
    
    file_path = './' + cat + '.js'
    with open(file_path, 'w') as file:
        file.write(s)
    print(cat + '.js file generated')