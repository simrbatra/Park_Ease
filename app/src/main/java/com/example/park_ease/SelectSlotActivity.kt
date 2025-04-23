package com.example.park_ease



import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.park_ease.R

class SelectSlotActivity : AppCompatActivity() {

    private lateinit var slotViews: List<TextView>
    private var selectedSlot: TextView? = null
    private lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_slot_fragment)

        // Initialize slot views (Add all actual IDs you used in XML)
        slotViews = listOf(
            findViewById(R.id.slotA01),
            findViewById(R.id.slotA04),
            findViewById(R.id.slotA05),
            findViewById(R.id.slotA08),
            findViewById(R.id.slotA10),
            findViewById(R.id.slotA12)
        )

        continueButton = findViewById(R.id.continueButton)

        setupSlotSelection()
        setupContinueAction()
    }

    private fun setupSlotSelection() {
        for (slot in slotViews) {
            slot.setOnClickListener {
                // Clear previous selection
                selectedSlot?.background = getDrawable(R.drawable.bg_slot_border)
                selectedSlot?.setTextColor(getColor(R.color.primaryText))

                // Select new one
                selectedSlot = slot
                slot.background = getDrawable(R.drawable.bg_slot_selected)
                slot.setTextColor(getColor(android.R.color.white))
            }
        }
    }

    private fun setupContinueAction() {
        continueButton.setOnClickListener {
            selectedSlot?.let {
                Toast.makeText(this, "Selected slot: ${it.text}", Toast.LENGTH_SHORT).show()
                // Start booking flow or navigate next
            } ?: run {
                Toast.makeText(this, "Please select a slot", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
