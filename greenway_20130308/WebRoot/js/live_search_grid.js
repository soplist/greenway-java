
Ext.Loader.setConfig({enabled: true});

Ext.Loader.setPath('Ext.ux', 'ux/');

Ext.require([
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.util.*',
    'Ext.ModelManager',
    'Ext.tip.QuickTipManager',
    'Ext.ux.LiveSearchGridPanel'
]);
Ext.onReady(function() {
    Ext.QuickTips.init();
    Ext.define('ForumThread', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'int',mapping: 'id'},
            {name: 'title',type: 'string', mapping: 'title'},
            {name: 'context',type: 'string', mapping: 'context'},
        ],//mapping to JSON Object key
        idProperty: 'id'
    });
    
    
    var store = Ext.create('Ext.data.Store', {
        pageSize: 50,
        model: 'ForumThread',
        remoteSort: true,
        proxy:{
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: 'listNote!jsonExecute.action',
            reader: {
            	type: 'json',
            	root: 'result',
            	totalproperty : "total",
            },
            // sends single sort as multi parameter
            simpleSortMode: true
        },
        sorters: [{
            property: 'id',
            direction: 'DESC'
        }]
    });
  
  
    Ext.create('Ext.ux.LiveSearchGridPanel', {
        store: store,
        columnLines: true,
        columns:[{
            // id assigned so we can apply custom css (e.g. .x-grid-cell-topic b { color:#333 })
            // TODO: This poses an issue in subclasses of Grid now because Headers are now Components
            // therefore the id will be registered in the ComponentManager and conflict. Need a way to
            // add additional CSS classes to the rendered cells.
            id: 'id',
            text: "Id",
            dataIndex: 'id',
            flex: 1,
            sortable: false
        },{
            text: "Title",
            dataIndex: 'title',
            width: 100,
            sortable: true
        },{
            text: "Context",
            dataIndex: 'context',
            width: 70,
            align: 'right',
            sortable: true
        }],
        height: 350,
        width: 600,
        title: 'Live Search Grid',
        renderTo: 'grid-example',
        viewConfig: {
            stripeRows: true
        }
    });
});