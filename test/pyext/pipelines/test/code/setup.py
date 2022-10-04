from setuptools import setup, find_packages
setup(
    name = 'test',
    version = '1.0',
    packages = find_packages(include = ('test*', )) + ["prophecy_config_instances"],
    package_dir = {'prophecy_config_instances' : 'configs/resources/config'},
    package_data = {'prophecy_config_instances' : ['*.json', '*.py']},
    description = 'workflow',
    install_requires = [
'prophecy-libs==1.3.5'],
    entry_points = {
'console_scripts' : [
'main = test.pipeline:main', ], },
    extras_require = {
'test' : ['pytest', 'pytest-html'], }
)
