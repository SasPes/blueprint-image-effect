 Blueprint Image Effect

[![License](https://img.shields.io/github/license/saspes/blueprint-image-effect.svg)](https://opensource.org/licenses/MIT) [![Build Status](https://travis-ci.org/SasPes/blueprint-image-effect.svg?branch=master)](https://travis-ci.org/SasPes/blueprint-image-effect) [![Coverage Status](https://coveralls.io/repos/github/SasPes/blueprint-image-effect/badge.svg?branch=master)](https://coveralls.io/github/SasPes/blueprint-image-effect?branch=master) [![Paypal](https://img.shields.io/badge/donate-PayPal-blue.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=TRTGCN324YEXA&currency_code=EUR&source=url)

![blueprint](/examples/bp.png)

https://blueprint-image-effect.onrender.com/blueprint?pngImage=

:information_source:️ Hobby projects with slow Docker instance 512 MB (RAM) & 0.1 CPU

### Docker
```
mvn package

# build
docker build -t saspesdocker/blueprint-image-effect .

# push to Docker Hub
docker push saspesdocker/blueprint-image-effect:latest

# run
docker container run saspesdocker/blueprint-image-effect -p 8080:8080
```