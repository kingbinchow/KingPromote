cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "file": "plugin-custom/startActivityJs.js",
        "id": "custompluginId",
        "clobbers": [
            "customplugin"
        ]
    }
];
module.exports.metadata = 
// TOP OF METADATA
{
    "cordova-plugin-whitelist": "1.2.2"
};
// BOTTOM OF METADATA
});