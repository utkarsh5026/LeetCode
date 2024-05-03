def count_java_lines(directory):
    import os
    count = 0
    for root, dirs, files in os.walk(directory):
        for file in files:
            if file.endswith('.java'):
                with open(os.path.join(root, file), 'r') as f:
                    count += len(f.readlines())
    return count


if __name__ == '__main__':
    print(count_java_lines('.'))
