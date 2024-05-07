# given a folder a name create folder and then create three sub folders easy, medium, hard
import os


def create_folders(folder_name):
    try:
        os.makedirs(folder_name)
        os.makedirs(folder_name + '/easy')
        os.makedirs(folder_name + '/medium')
        os.makedirs(folder_name + '/hard')
    except OSError as e:
        print(e)
        return False
    return True


dataStructures = ['arrays', 'linked_lists', 'stacks', 'queues',
                  'trees', 'graphs', 'heaps', 'hash_tables', 'strings']

alogorithms = ['dynamic_programming', 'greedy',
               'two_pointers', 'backtracking', 'sliding_window']


for ds in dataStructures:
    create_folders(ds)

for algo in alogorithms:
    create_folders(algo)
