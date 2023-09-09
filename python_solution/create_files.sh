#!/bin/bash

# 指定文件夹路径
folder_path=$(pwd)  # 获取当前文件夹路径

# 创建100个文件
for ((i=1; i<=100; i++)); do
    file_name="${i}.py"
    file_path="${folder_path}/${file_name}"
    
    # 检查文件是否已存在，如果存在则跳过
    if [ ! -e "$file_path" ]; then
        touch "$file_path"
    else
        echo "文件 ${file_name} 已存在，跳过创建。"
    fi
done

