console.log("This is first test");
console.log("trying to create node server");

var http = require('http');

http.createServer(function(req, resp) {
	resp.writeHead(200, {'Content-Type': 'text/html'});
	resp.end("Bhuck Bosdike!");
}).listen(8080);

console.log("Well done finally run server");