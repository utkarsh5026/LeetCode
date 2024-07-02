import os
from tabulate import tabulate
import argparse

TO_SKIP = 'analyze'


def get_topics_paths(root_dir: str) -> list[str]:
    topics = os.listdir(root_dir)
    topic_paths = []

    for topic in topics:
        topic_path = os.path.join(root_dir, topic)
        if os.path.isdir(topic_path) and topic != TO_SKIP:
            topic_paths.append(topic_path)
    return topic_paths


def count_files_per_level(topic_path: str) -> dict[str]:
    levels = os.listdir(topic_path)
    level_files = {}

    for level in levels:
        level_path = os.path.join(topic_path, level)
        files = os.listdir(level_path)
        level_files[level] = len(files)

    return level_files


def get_all_topic_paths():
    curr_dir = os.getcwd()
    parent_dir = os.path.dirname(curr_dir)
    topic_paths = get_topics_paths(parent_dir)
    return topic_paths


def show_files_per_topic():
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


def count_lines_per_level(topic_path: str) -> tuple[dict[str]]:
    levels = os.listdir(topic_path)
    level_lines = {}
    level_average = {}

    for level in levels:
        level_path = os.path.join(topic_path, level)
        files = [f for f in os.listdir(level_path) if os.path.isfile(
            os.path.join(level_path, f))]
        lines_cnt = 0
        for file in files:
            file_path = os.path.join(level_path, file)
            with open(file_path, 'r') as f:
                lines = f.readlines()
                lines_cnt += len(lines)

        level_lines[level] = lines_cnt
        level_average[level] = lines_cnt / len(files) if len(files) > 0 else 0

    return level_lines, level_average


def show_lines_per_topic():
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

    parser = argparse.ArgumentParser(description='Analyzer for the files 🥺🥺🥺')

    # add boolean arguments
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
