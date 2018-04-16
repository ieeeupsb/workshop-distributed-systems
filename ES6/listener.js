if(process.argv.length < 4){
    console.log("Need an address and a port number, in that order")
    process.exit(-1)
}

const dgram = require('dgram')
const server = dgram.createSocket("udp4")

server.on('error', (error) => {
    console.log(error)
    server.close()
})

server.on('message', (msg, rinfo) => {
    console.log(`server got: ${msg} from ${rinfo.address}:${rinfo.port}`)
});

server.on('listening', () => {
    const address = server.address()
    console.log(`server listening ${address.address}:${address.port}`)
});



server.bind(Number.parseInt(process.argv[3]), () => server.addMembership(process.argv[2]))
  
  