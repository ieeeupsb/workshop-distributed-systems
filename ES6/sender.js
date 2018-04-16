if(process.argv.length < 4){
    console.log("Need an address and a port number, in that order")
    process.exit(-1)
}


const dgram = require('dgram');

const message = Buffer.from('testing');

const client = dgram.createSocket('udp4');
//client.setMulticastTTL(1)

client.send(message, Number.parseInt(process.argv[3]), process.argv[2], (err) => {
  console.log(err)
  client.close();
});