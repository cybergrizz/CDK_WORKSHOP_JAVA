exports.handler = async function(event) {
	console.log("request:", JSON.stringify(event, undefined, 2));
	return {
		statusCode: 200,
		headers: { "Contyent-Type": ":text/plain" },
		body: 'Good Evening ladies\n'
	};
}
