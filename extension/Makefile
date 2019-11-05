version := $(shell cat VERSION)

.PHONY: jar
jar:
	cd scalalistener && sbt package

.PHONY: js
js:
	yarn install
	yarn run webpack

.PHONY: wheel
wheel: js jar
	rm -f dist/*
	python setup.py sdist bdist_wheel

.PHONY: install
install: wheel
	-pip uninstall sparkmonitor -y
	pip install $(wildcard dist/*.whl)

.PHONY: upload
ifndef SPARK_MONITOR_UPLOAD_BASE
upload:
	@echo ERROR: expect SPARK_MONITOR_UPLOAD_BASE to be set.
	exit 1
else
wheel_name = $(wildcard dist/*.whl)
gs_path = $(SPARK_MONITOR_UPLOAD_BASE)/sparkmonitor-$(shell git rev-parse HEAD)/$(notdir $(wheel_name))
upload: wheel
	echo copying to $(gs_path)
	gsutil cp $(wheel_name) $(gs_path)
	gsutil retention temp set $(gs_path)
endif