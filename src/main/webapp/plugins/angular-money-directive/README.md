# angular-money-directive

[![Build Status](http://img.shields.io/travis/fiestah/angular-money-directive.svg)](http://travis-ci.org/fiestah/angular-money-directive)

[Quick Demo](https://fiestah.github.io/angular-money-directive/)

This directive validates monetary inputs in "42.53" format (some additional work is needed for "32,00" European formats). Note that this is _not_ designed to work with currency symbols. It largely behaves like Angular's implementation of `type="number"`.

It does a few things:

- Prevents entering non-numeric characters
- Prevents entering the minus sign when `min >= 0`
- Supports `min` and `max` like in `<input type="number">`
- Rounds the model value by `precision`, e.g. `42.219` will be rounded to `42.22` by default
- On `blur`, the input field is auto-formatted. Say if you enter `42`, it will be formatted to `42.00`

Version 1.2.x supports Angular 1.3 and up. Version 1.1.x will continue to work for Angular 1.2.


## Usage:

```
npm install angular-money-directive
```

or

```
bower install angular-money-directive
```


Load the unminified or minified file from `dist` dir:

```
<script src="dist/angular-money-directive.js"></script>
```

Then include it as a dependency in your app.

```
angular.module('myApp', ['fiestah.money'])
```


### Attributes:

- `money`: _required_
- `ng-model`: _required_
- `type`: Set to `text` or just leave it out. Do _not_ set to `number`.
- `min`: _optional_ Defaults to `0`.
- `max`: _optional_ Not enforced by default
- `precision`: _optional_ Defaults to `2`. Set to `-1` to disable rounding. Rounding is also disabled if `parseInt(precision, 10)` does not return `0` or higher.

Basic example:

``` html
<input type="text" ng-model="model.price" money>
```

`min`, `max` and `precision` can be set dynamically:

``` html
<input type="text" ng-model="model.price" money min="{{min}}" max="{{max}}" precision="{{precision}}">
```

## Tests:

1. Install test deps: `npm install`
1. Run: `./node_modules/karma/bin/karma start`
