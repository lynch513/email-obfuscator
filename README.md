# email-obfuscator for Clojure

A Clojure library designed to obfuscating e-mails. This is my port of html-email-obfuscator for Node.js:

[https://github.com/Pfarrer/html-email-obfuscator](https://github.com/Pfarrer/html-email-obfuscator)

This library combines some email obfuscation technics.

- The @ char is removed and only its index is passed on.
- The address itself will be transmitted as a ROT13 transformed string which will be retransformed by Javascript or by unobfuscate function.

### Installation

Add the following dependency to your project.clj file:

    [email-obfuscator "0.1.0-SNAPSHOT"]

## Usage

The e-mail "first@example.com" will result in the following string:

```clojure
user=>(use 'email-obfuscator.core)
nil
user=>(obfuscate "first@example.com")
"svefgrknzcyr.pbz/5"
user=>(unobfuscate "svefgrknzcyr.pbz/5")
"first@example.com"
user=>(use 'email-obfuscator.html)
nil
user=>(as-html-string "first@example.com")
See below
```

as-html-string output can be included instead of the email address:

```html
<script type="text/javascript">
var action=':otliam'.split('').reverse().join('');
var href='svefgrknzcyr.pbz'.replace(/[a-zA-Z]/g, function(c){return String.fromCharCode((c<='Z'?90:122)>=(c=c.charCodeAt(0)+13)?c:c-26);});
href=href.substr(0,5)+String.fromCharCode(4*2*2*4)+href.substr(5);
var a='<a href=\"'+action+href+'\">'+href+'</a>';
document.write(a);
</script>
```
## License

Copyright © 2018 lynch513

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
