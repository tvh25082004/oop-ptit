.PHONY: push

push:
	@read -p "Nhập nội dung commit: " msg && \
	git add -A && \
	git commit -m "$$msg" && \
	git push origin main
