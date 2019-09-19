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
