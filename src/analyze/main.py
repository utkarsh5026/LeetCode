import os
from tabulate import tabulate
import argparse

TO_SKIP = 'analyze'


def get_topics_paths(root_dir: str) -> list[str]:
    """
    Retrieve paths for all topics in a given directory, excluding any specified directories to skip.

    Parameters:
        root_dir (str): The root directory from which to gather topic paths.

    Returns:
        list[str]: A list containing paths of all topics found in the root directory.
    """
    topics = os.listdir(root_dir)
    topic_paths = []
    for topic in topics:
        topic_path = os.path.join(root_dir, topic)
        if os.path.isdir(topic_path) and topic != TO_SKIP:
            topic_paths.append(topic_path)
    return topic_paths


def count_files_per_level(topic_path: str) -> dict[str, int]:
    """
    Count the number of files in each subdirectory of a given topic path.

    Parameters:
        topic_path (str): Path to the topic directory.

    Returns:
        dict[str, int]: A dictionary where keys are subdirectory names and values are file counts.
    """
    levels = os.listdir(topic_path)
    level_files = {}
    for level in levels:
        level_path = os.path.join(topic_path, level)
        files = os.listdir(level_path)
        level_files[level] = len(files)
    return level_files


def get_all_topic_paths() -> list[str]:
    """
    Get all topic paths from the parent directory of the current working directory.

    Returns:
        list[str]: A list of topic paths.
    """
    curr_dir = os.getcwd()
    parent_dir = os.path.dirname(curr_dir)
    return get_topics_paths(parent_dir)


def show_files_per_topic():
    """
    Display a formatted table of topics along with the number of files per subdirectory and total files.
    """
    topic_paths = get_all_topic_paths()
    table = {}
    for topic_path in topic_paths:
        topic_name = os.path.basename(topic_path)
        files_per_topic = count_files_per_level(topic_path)
        table[topic_name] = files_per_topic

    headers = set()
    for topic in table:
        headers.update(table[topic].keys())
    headers = list(headers)
    headers.insert(0, 'Topic')
    headers.append('Total')

    rows = []
    for topic in table:
        row = [topic]
        cnt = 0
        for header in headers[1:-1]:
            row.append(table[topic].get(header, 0))
            cnt += table[topic].get(header, 0)
        row.append(cnt)
        rows.append(row)

    headers = [header.capitalize() for header in headers]
    print(tabulate(rows, headers=headers, tablefmt='fancy_grid'))


def count_lines_per_level(topic_path: str) -> tuple[dict[str, int], dict[str, float]]:
    """
    Count the total number of lines in each file for each subdirectory of a topic path, along with the average lines per file.

    Parameters:
        topic_path (str): Path to the topic directory.

    Returns:
        tuple[dict[str, int], dict[str, float]]: A tuple containing two dictionaries:
            - Total lines per subdirectory
            - Average lines per file per subdirectory
    """
    levels = os.listdir(topic_path)
    level_lines = {}
    level_average = {}
    for level in levels:
        level_path = os.path.join(topic_path, level)
        files = [f for f in os.listdir(level_path) if os.path.isfile(
            os.path.join(level_path, f))]
        lines_count = 0
        for file in files:
            with open(os.path.join(level_path, file), 'r') as f:
                lines = f.readlines()
                lines_count += len(lines)
        level_lines[level] = lines_count
        level_average[level] = lines_count / len(files) if files else 0
    return level_lines, level_average


def show_lines_per_topic():
    """
    Display a formatted table of topics along with the number of lines per subdirectory and total lines.
    """
    topic_paths = get_all_topic_paths()
    lines_per_topic = {}
    for topic_path in topic_paths:
        topic_name = os.path.basename(topic_path)
        lines, _ = count_lines_per_level(topic_path)
        lines_per_topic[topic_name] = lines

    headers = set()
    for topic in lines_per_topic:
        headers.update(lines_per_topic[topic].keys())
    headers = list(headers)
    headers.insert(0, 'Topic')
    headers.append('Total')

    rows = []
    for topic in lines_per_topic:
        row = [topic]
        cnt = 0
        for header in headers[1:-1]:
            row.append(lines_per_topic[topic].get(header, 0))
            cnt += lines_per_topic[topic].get(header, 0)
        row.append(cnt)
        rows.append(row)

    headers = [header.capitalize() for header in headers]
    print(tabulate(rows, headers=headers, tablefmt='fancy_grid'))


def main():
    """
    Main function to parse command line arguments and execute functions based on the input arguments.
    """
    parser = argparse.ArgumentParser(description='Analyzer for the files 🥺🥺🥺')
    parser.add_argument('--lines', action='store_true',
                        help='Show lines per topic')
    parser.add_argument('--files', action='store_true',
                        help='Show files per topic')
    args = parser.parse_args()

    if args.lines:
        show_lines_per_topic()
    if args.files:
        show_files_per_topic()
    if not args.lines and not args.files:
        print(
            "Please provide an argument to show the data. Use --help for more information.")


if __name__ == '__main__':
    main()
