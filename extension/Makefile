.PHONY: jar
jar:
	cd scalalistener && sbt package

.PHONY: js
js:
	yarn install
	yarn run webpack

.PHONY: install
install: js jar
	rm -f dist/*
	python setup.py sdist bdist_wheel
	-pip uninstall sparkmonitor -y
	pip install $(wildcard dist/*.whl)
