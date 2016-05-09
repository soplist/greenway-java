
Ext.Loader.setConfig({enabled: true});

Ext.Loader.setPath('Ext.ux', 'ux/');

Ext.require([
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.util.*',
    'Ext.toolbar.Paging',
    'Ext.ux.PreviewPlugin',
    'Ext.ModelManager',
    'Ext.tip.QuickTipManager'
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
  
    var pluginExpanded = true;
    
    var grid = Ext.create('Ext.grid.Panel', {
        width: 1000,
        height: 600,
        title: 'ExtJS.com - Browse Forums',
        store: store,
        disableSelection: true,
        loadMask: true,
        viewConfig: {
            id: 'gv',
            trackOver: false,
            stripeRows: false,
            plugins: [{
                ptype: 'preview',
                bodyField: 'excerpt',
                expanded: true,
                pluginId: 'preview'
            }]
        },
        // grid columns
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
        // paging bar on the bottom
        bbar: Ext.create('Ext.PagingToolbar', {
            store: store,
            displayInfo: true,
            displayMsg: 'Displaying topics {0} - {1} of {2}',
            emptyMsg: "No topics to display",
            items:[
                '-', {
                text: 'Show Preview',
                pressed: pluginExpanded,
                enableToggle: true,
                toggleHandler: function(btn, pressed) {
                    var preview = Ext.getCmp('gv').getPlugin('preview');
                    preview.toggleExpanded(pressed);
                }
            }]
        }),
        renderTo: 'topic-grid'
    });

    // trigger the data store load
    
    store.loadPage(1);
    
});