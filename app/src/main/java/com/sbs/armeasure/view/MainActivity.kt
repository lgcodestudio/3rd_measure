package com.sbs.armeasure.view

import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.sbs.armeasure.R

class MainActivity : BaseActivity() {

    lateinit var arFragment: ArFragment
    lateinit var modelRenderable : ModelRenderable

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        arFragment = supportFragmentManager.findFragmentById(R.id.ux_fragment) as ArFragment

        ModelRenderable.builder()
                .setSource(this, R.raw.andy)
                .build()
                .thenAccept{renderable : ModelRenderable -> modelRenderable = renderable}
                .exceptionally{_ ->
                    null
                }
        arFragment.setOnTapArPlaneListener{ hitResult, plane, motionEvent ->
            if(modelRenderable == null){

            }

            var anchor = hitResult.createAnchor()
            var anchorNode = AnchorNode(anchor)

        }
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
