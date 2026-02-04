#!/bin/bash

# Script để compile, chạy và tự động xóa file .class

if [ $# -eq 0 ]; then
    echo "Cách dùng: ./run.sh <tên_file_java>"
    echo "Ví dụ: ./run.sh \"COLLECTION001 - Nhà kho.java\""
    exit 1
fi

JAVA_FILE="$1"

# Kiểm tra file có tồn tại không
if [ ! -f "$JAVA_FILE" ]; then
    echo "Lỗi: File '$JAVA_FILE' không tồn tại!"
    exit 1
fi

# Compile file Java
echo "Đang compile: $JAVA_FILE"
javac "$JAVA_FILE"

if [ $? -ne 0 ]; then
    echo "Lỗi khi compile!"
    exit 1
fi

# Chạy chương trình
echo "Đang chạy chương trình..."
echo "----------------------------------------"
java Main

# Lưu exit code
EXIT_CODE=$?

# Xóa tất cả file .class sau khi chạy
echo "----------------------------------------"
echo "Đang xóa các file .class..."
rm -f *.class

if [ $EXIT_CODE -eq 0 ]; then
    echo "Hoàn thành!"
else
    echo "Chương trình kết thúc với lỗi (exit code: $EXIT_CODE)"
fi

exit $EXIT_CODE
